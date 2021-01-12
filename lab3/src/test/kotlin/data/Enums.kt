package data

enum class Region(val value: String) {
    NorthAmerica("Северная Америка"),
    SouthAmerica("Южная Америка"),
    OceaniaAndAsia("Страны Азии и Тихого океана"),
    EuropeAndAfrica("Страны Азии и Тихого океана")
}

enum class Category(val value: String) {
    VEHICLE("Автотранспортные средства"),
    BUSINESS("Бизнес и промышленность"),
    STATE("Государство и право"),
    ANIMALS("Дикие и домашние животные"),
    HOME_AND_GARDEN("Дом и сад")
}

enum class ArticleTitle(val value: String) {
    EARN_ON_BLOG("Как заработать на блоге"),
    MONETIZATION_ADVICES("Советы по монетизации сайта с помощью Google AdSense"),
    SITE_OPTIMIZATION("Как оптимизировать сайт и повысить доход от AdSense"),
    SITE_PREPARATION("Как подготовить свой сайт для работы с AdSense")
}