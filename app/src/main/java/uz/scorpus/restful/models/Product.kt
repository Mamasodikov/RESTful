package uz.scorpus.restful.models

data class Product(
    var id:Int,
    var name:String,
    var price:String,
    var image:String,
    var category_id:String,
    var created_at:String,
    var updated_at:String
)
