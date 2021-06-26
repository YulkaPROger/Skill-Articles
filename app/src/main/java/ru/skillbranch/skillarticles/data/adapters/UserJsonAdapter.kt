package ru.skillbranch.skillarticles.data.adapters

import org.json.JSONObject
import ru.skillbranch.skillarticles.data.local.User
import ru.skillbranch.skillarticles.extensions.asMap

class UserJsonAdapter() : JsonAdapter<User> {
    override fun fromJson(json: String): User? {
        if (json.isEmpty()) return null
        JSONObject(json).run {
            val id = getString("id")
            val name = getString("name")
            val avatar: String? = if (!isNull("avatar")) getString("avatar") else null
            val rating: Int = getInt("rating")
            val respect: Int = getInt("respect")
            val about: String? = if (!isNull("about")) getString("about") else null
            return User(id, name, avatar, rating, respect, about)
        }
    }

    override fun toJson(obj: User?): String {
        return obj?.let {
            JSONObject(it.asMap()).toString()
        } ?: ""
    }
}