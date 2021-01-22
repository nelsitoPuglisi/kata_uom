package com.nelsito.kata_uom

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import java.io.File

class MySampleShould {

    @Test
    fun `have a failing sample`() {
        //given
        val mySample = MySample()
        //when
        val actual = mySample.greetings("Alice")
        //then
        val expected = "Hello Alice!"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `have an expected exception sample`() {
        //given
        val mySample = MySample()
        //when
        //then
        assertThatThrownBy { mySample.greetings("") }
            .hasMessage("Name is mandatory")
    }

    @Test
    fun `have a load json file`() {
        //given
        val json = File("src/test/units.json").readText()
        val jsonElement = Json.parseToJsonElement(json) as JsonObject
        println(jsonElement.toString())
        //when
        val actual = ((jsonElement["unit aliases"] as JsonObject)["acre"] as JsonPrimitive).content
        //then
        val expected = "ac"
        assertThat(actual).isEqualTo(expected)
    }
}