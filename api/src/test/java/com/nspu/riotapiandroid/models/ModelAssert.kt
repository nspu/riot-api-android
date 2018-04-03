package fr.nspu.riot.api

import android.os.Parcelable
import org.fest.assertions.api.AbstractAssert
import org.fest.assertions.api.Assertions
import java.lang.reflect.Field

class ModelAssert protected constructor(actual: Parcelable, selfType: Class<*>) : AbstractAssert<ModelAssert, Parcelable>(actual, selfType) {

    fun isEqualByComparingFields(expected: Parcelable): ModelAssert {

        val fields = expected.javaClass.fields
        for (field in fields) {
            try {
                val fieldName = expected.javaClass.simpleName + "#" + field.name

                val actualField = field.get(actual)
                val expectedField = field.get(expected)

                if (isList(field)) {
                    compareLists(fieldName, actualField as List<*>, expectedField as List<*>)
                } else {

                    // The maps in current models only contain simple types so we skip any fancy
                    // comparisons and use regular compare

                    compareFields(fieldName, expectedField, actualField)
                }

            } catch (e: IllegalAccessException) {
                throw AssertionError("Can't access fields")
            }

        }

        return this
    }

    private fun compareLists(fieldName: String, actual: List<*>?, expected: List<*>?) {
        if (actual == null || expected == null) {
            compareFields(fieldName, expected, actual)
            return
        }

        for (i in actual.indices) {
            compareFields(fieldName, expected[i], actual[i])
        }
    }

    private fun isList(field: Field): Boolean {
        return List::class.javaObjectType == field.type
    }

    private fun compareFields(fieldName: String, expected: Any?, actual: Any?): AbstractAssert<*,*> {
        if (actual is Parcelable) {
            return ModelAssert.assertThat(actual)
                    .isEqualByComparingFields(expected as Parcelable)
        }

        // Be nice and show which field in which class is failing
        val fieldPath = this.actual.javaClass.simpleName + "#" + fieldName

        return Assertions.assertThat(actual)
                .overridingErrorMessage(ERROR_MESSAGE, expected, actual, fieldPath)
                .isEqualTo(expected)
    }

    companion object {

        val ERROR_MESSAGE = "\nExpected : <%s> \nActual   : <%s> \nat %s"

        fun assertThat(actual: Parcelable): ModelAssert {
            return ModelAssert(actual, ModelAssert::class.java)
        }
    }
}
