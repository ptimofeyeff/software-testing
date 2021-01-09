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