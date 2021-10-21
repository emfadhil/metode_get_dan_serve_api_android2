package com.fadhil.news_api.model

class Berita {

    var status : String? = null
    var totalResults : Int? = null
    var articles : ArrayList<ItemBerita>? = null
}

class ItemBerita{
    var id : String? = null
    var title : String? = null
    var description : String? = null
    var urlToImage : String? = null
}