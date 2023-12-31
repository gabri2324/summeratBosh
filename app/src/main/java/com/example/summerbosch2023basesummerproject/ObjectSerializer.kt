package com.example.summerbosch2023basesummerproject

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable


object ObjectSerializer {

        /**
         * Serialize given object into [String] using [ObjectOutputStream].
         * @param obj object to serialize
         * @see ObjectInputStream
         * @return the serialization result, empty string for _null_ input
         */
        fun <T : java.io.Serializable> serialize(obj: T?): String {
            if (obj == null) {
                return ""
            }

            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(obj)
            oos.close()

            return baos.toString("ISO-8859-1")
        }

        /**
         * Deserialize given [String] using [ObjectInputStream].
         * @param string the string to deserialize
         * @return deserialized object, null, in case of error.
         */
        fun <T : java.io.Serializable> deserialize(string: String): T? {
            if (string.isEmpty()) {
                return null
            }

            var bais = ByteArrayInputStream(string.toByteArray(charset("ISO-8859-1")))
            var ois = ObjectInputStream(bais)

            return ois.readObject() as T
        }

        fun <T : Serializable> deserialize(string: String, clazz: Class<T>): T? = deserialize<T>(string)

    }
