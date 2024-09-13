package hr.algebra.heroapp.model

data class Item(
    var _id: Long?,
    val name: String,
    val intelligence: Long,
    val strength: Long,
    val speed: Long,
    val durability: Long,
    val power: Long,
    val combat: Long,
    val gender: String,
    val race: String?,
    val picturePath: String,
    var read: Boolean
)
