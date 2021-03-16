/**
 * Enum со списком стран.
 */
public enum Country {
    PANDALAND("Пандия", false),
    HAMSTERLAND("Хомалэнд", false),
    CORGILAND("Коржлэнд", false),
    SPIDERLAND("Австралия", true);


    private final String ruName;
    private final boolean isOpen;

    /**
     * Конструктор страны-элемента.
     *
     * @param ruName название страны на русском
     * @param isOpen открыта ли страна для посещения (true - открыта, false - закрыта)
     */
    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    /**
     * @return название страны-элемента
     */
    @Override
    public String toString() {
        return (this.name() + " (" + this.ruName + ")");
    }

    /**
     * Геттер для поля isOpen.
     *
     * @return - возвращает значение поля isOpen
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Поиск страны по русскому названию.
     *
     * @param ruName строка с русским названием страны
     * @return возвращает страну-элемент, русское название которой соответствует заданному
     * @throws NoSuchCountryException если соответствующая страна не найдена
     */
    public static Country getByRuName(final String ruName) throws NoSuchCountryException {
        Country country;

        Country[] countryList = Country.values();

        /*
         * Поиск страны по всем элементам перечисления.
         * Если нашли - возвращаем
         */
        for (Country c : countryList) {
            if (c.ruName.equals(ruName)) {
                return c;
            }
        }

        // Не нашли - выкидываем исключение
        throw new NoSuchCountryException();
    }
}
