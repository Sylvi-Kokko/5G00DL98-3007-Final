import kotlinx.serialization.Serializable

@Serializable
data class Spell (
    val index: String = "",
    val name: String = "",
    val desc: List<String> = emptyList(),
    val range: String = "",
    val components: List<String> = emptyList(),
    val ritual: Boolean = false,
    val duration: String = "",
    val concentration: Boolean = false,
    val castingTime: String = "1 Action",
    val level: Long = 0,
    val dc: Dc = Dc(),
    val areaOfEffect: AreaOfEffect = AreaOfEffect(),
    val school: School = School(),
    val classes: List<School> = emptyList(),
    val subclasses: List<School> = emptyList(),
    val url: String = ""
)

@Serializable
data class AreaOfEffect (
    val type: String = "",
    val size: Long = 0
)

@Serializable
data class School (
    val index: String = "",
    val name: String = "",
    val url: String = ""
)

@Serializable
data class Dc (
    val dcType: School = School(),
    val dcSuccess: String = ""
)
