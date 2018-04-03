package com.nspu.riotapi

import android.os.Parcelable
import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType
import java.util.*


class ModelPopulator(vararg excludeFields: String) {
    private val mExcludeFields: MutableList<String>

    class PopulationException(details: String, throwable: Throwable) : RuntimeException(details, throwable)

    init {
        mExcludeFields = ArrayList()
        for (field in excludeFields) {
            mExcludeFields.add(field.toLowerCase())
        }
    }

    fun <T> populateWithRandomValues(type: Class<T>): T {
        try {
            val instance = type.newInstance()

            val fields = ArrayList(Arrays.asList(*type.declaredFields))
            fields.addAll(getInheritedFields(type))

            for (field in fields) {
                field.isAccessible = true
                if (shouldSkipField(field)) {
                    continue
                }

                if (isCollectionType(field.type)) {
                    field.set(instance, populateCollectionField(field))
                } else {
                    field.set(instance, getRandomValueOfType(field.type))
                }
            }

            return instance
        } catch (e: Exception) {
            throw PopulationException("Populating object failed", e)
        }

    }

    private fun shouldSkipField(field: Field): Boolean {
        return mExcludeFields.contains(field.name.toLowerCase())
    }

    private fun getInheritedFields(type: Class<*>): List<Field> {
        var type = type
        val inheritedFields = ArrayList<Field>()
        while (type.superclass != null) {
            val superclass = type.superclass
            inheritedFields.addAll(Arrays.asList(*superclass.declaredFields))
            type = superclass
        }
        return inheritedFields
    }

    private fun isCollectionType(type: Class<*>): Boolean {
        return Map::class.java.isAssignableFrom(type) || List::class.java.isAssignableFrom(type) || Set::class.java.isAssignableFrom(type)
    }

    private fun populateCollectionField(field: Field): Any {

        val type = field.type

        /* List */
        if (List::class.java.isAssignableFrom(type)) {
            val genericType = field.genericType
            val pt = genericType as ParameterizedType
            val actualType = pt.actualTypeArguments[0]
            val elementClass: Class<*>

            if (actualType is Class<*>) {
                elementClass = actualType
            } else {
                // Lists with generics will be populated by default type
                elementClass = DEFAULT_GENERIC_CLASS
            }

            val list = ArrayList<Any>()
            for (i in 0 until DEFAULT_COLLECTION_SIZE) {
                list.add(getRandomValueOfType(elementClass)!!)
            }
            return list
        }

        /* Map */
        if (Map::class.java.isAssignableFrom(type)) {
            val genericType = field.genericType
            val pt = genericType as ParameterizedType
            val arguments = pt.actualTypeArguments

            val key = arguments[0]
            val value = arguments[1]

            val keyClass: Class<*>
            if (key is Class<*>) {
                keyClass = key
            } else {
                // Maps with generics will be populated by default type
                keyClass = DEFAULT_GENERIC_CLASS
            }

            val valueClass: Class<*>
            if (value is Class<*>) {
                valueClass = value
            } else {
                // Maps with generics will be populated by default type
                valueClass = DEFAULT_GENERIC_CLASS
            }

            val map = emptyMap<Any, Any>()
            for (i in 0 until DEFAULT_COLLECTION_SIZE) {
                map.plus(Pair(getRandomValueOfType(keyClass), getRandomValueOfType(valueClass)))
            }
            return map
        }

        /* Set */
        if (Set::class.java.isAssignableFrom(type)) {
            val genericType = field.genericType
            val pt = genericType as ParameterizedType
            val actualType = pt.actualTypeArguments[0]
            val elementClass: Class<*>

            if (actualType is Class<*>) {
                elementClass = actualType
            } else {
                // Sets with generics will be populated by default type
                elementClass = DEFAULT_GENERIC_CLASS
            }

            val list = emptySet<Any>()
            for (i in 0 until DEFAULT_COLLECTION_SIZE) {
                list.plus(getRandomValueOfType(elementClass)!!)
            }
            return list
        }

        throw UnsupportedOperationException("Unsupported collection field type! $type")
    }

    private fun getRandomValueOfType(type: Class<*>): Any? {

        /* Another model */
        if (Parcelable::class.java.isAssignableFrom(type)) {
            return populateWithRandomValues(type)
        }

        /* String */
        if (type == String::class.java) {
            val builder = StringBuilder()
            for (i in 0 until DEFAULT_STRING_LENGTH) {
                builder.append((RANDOM.nextInt(26) + 'a'.toInt()).toChar())
            }
            return builder.toString()
        }

        /* Integer */
        if (type == Integer.TYPE || type == Integer::class.javaObjectType) {
            return RANDOM.nextInt()
        }

        /* Double */
        if (type == java.lang.Double.TYPE || type == Double::class.javaObjectType) {
            return RANDOM.nextDouble()
        }

        /* Long */
        if (type == java.lang.Long.TYPE || type == Long::class.javaObjectType) {
            return RANDOM.nextLong()
        }

        /* Float */
        if (type == java.lang.Float.TYPE || type == Float::class.javaObjectType) {
            return RANDOM.nextFloat()
        }

        /* Boolean */
        if (type == java.lang.Boolean.TYPE || type == Boolean::class.javaObjectType) {
            return RANDOM.nextBoolean()
        }

        if (type == Any::class.javaObjectType) {
            return null
        }

        throw UnsupportedOperationException("Unsupported field type! $type")
    }

    companion object {

        val DEFAULT_STRING_LENGTH = 10
        val DEFAULT_COLLECTION_SIZE = 5

        val RANDOM = Random()
        val DEFAULT_GENERIC_CLASS: Class<String> = String::class.java
    }
}
