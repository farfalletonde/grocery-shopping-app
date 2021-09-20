package com.example.getirclone.model.productDetailCallbackModel

data class ProductDetailCallback(
    val aisle: String,
    val badges: List<String>,
    val brand: String,
    val breadcrumbs: List<String>,
    val description: String,
    val generatedText: String,
    val id: Int,
    val image: String,
    val imageType: String,
    val images: List<String>,
    val importantBadges: List<String>,
    val ingredientCount: Int,
    val ingredientList: String,
    val ingredients: List<Ingredient>,
    val likes: Int,
    val nutrition: Nutrition,
    val price: Double,
    val servings: Servings,
    val spoonacularScore: Double,
    val title: String,
    val upc: String
)