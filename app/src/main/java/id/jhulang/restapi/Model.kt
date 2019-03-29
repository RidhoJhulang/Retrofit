package id.jhulang.restapi

object Model {
    data class photo(
        val albumId  : Int = 0,
        val id : Int = 0,
        val title : String,
        val url : String,
        val thumbnailUrl : String
    )
}