package com.example.rp_cyberpunk_list.expand_rv_characteristic

class CharacteristicSkillsData() {
    private val characteristicList: List<Characteristics> = listOf(
        Characteristics("Интеллект", listOf(
            Skills("Скрытие/Раскрытие объекта"),
            Skills("Чтение по губам"),
            Skills("Внимательность"),
            Skills("Выслеживание"),
            Skills("Бухгалтерия"),
            Skills("Обращение с животными"),
            Skills("Бюрократия"),
            Skills("Бизнес"),
            Skills("Композиция"),
            Skills("Криминология"),
            Skills("Криптография"),
            Skills("Дедукция"),
            Skills("Образование"),
            Skills("Азартные игры"),
            Skills("Языки"),
            Skills("Знание местности"),
            Skills("Поиск информации"),
            Skills("Тактика"),
            Skills("Наука"),
            Skills("Выживание в пустыне")
        )),
        Characteristics("Реакция", listOf(
            Skills("Вождение"),
            Skills("Пилотирование"),
            Skills("Судоходство"),
            Skills("Верховая езда"),
            Skills("Стрельба из лука"),
            Skills("Автоматический огонь"),
            Skills("Пистолеты"),
            Skills("Оружие крупного калибра"),
            Skills("Тактическое оружие")
        )),
        Characteristics("Ловкость", listOf(
            Skills("Атлетика"),
            Skills("Акробатика"),
            Skills("Танец"),
            Skills("Скрытность"),
            Skills("Рукопашный бой"),
            Skills("Уклонение"),
            Skills("Боевые искусства"),
            Skills("Оружие ближнего боя")
        )),
        Characteristics("Техника", listOf(
            Skills("Авиационные технологии"),
            Skills("Знание техники"),
            Skills("Кибертехника"),
            Skills("Подрывник"),
            Skills("Электронника/Безопасность"),
            Skills("Первая помощь"),
            Skills("Фальсификация"),
            Skills("Автомеханика"),
            Skills("Художественное ремесло"),
            Skills("Парамедик"),
            Skills("Кино и фототехника"),
            Skills("Взлом замков"),
            Skills("Карманник"),
            Skills("Морские технологии"),
            Skills("Оружейник")
        )),
        Characteristics("Харизма", listOf(
            Skills("Актерское мастерство"),
            Skills("Подкуп"),
            Skills("Допрос"),
            Skills("Убеждение"),
            Skills("Уход за собой"),
            Skills("Знаток улиц"),
            Skills("Торговля"),
            Skills("Гардероб и стиль")
        )),
        Characteristics("Воля", listOf(
            Skills("Концентрация"),
            Skills("Выносливость"),
            Skills("Сопротивление пыткам/наркотикам")
        )),
        Characteristics("Эмпатия", listOf(
            Skills("Общение"),
            Skills("Проницательность")
        ))
    )

    fun prepareData(): List<Characteristics> {
        return characteristicList
    }

}