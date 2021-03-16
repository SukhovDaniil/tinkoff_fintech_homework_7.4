import java.util.Scanner;

public class CountryInspector {
    public static void main(final String[] args) throws NoSuchCountryException {
        Country[] countries = Country.values();

        // Выводим названи всех стран в консоль
        for (Country country : countries) {
            System.out.println(country.toString());
        }

        System.out.print("Введите название искомой страны: ");
        Scanner scanner = new Scanner(System.in);
        String countryName = scanner.next();

        /*
         * Пытаемся найти элемент по названию на английском
         */
        try {
            Country country = Country.valueOf(countryName.toUpperCase());

            if (country.isOpen()) {
                System.out.println("Страна [" + country.toString() + "] открыта для посещения.");
            } else {
                System.out.println("Страна [" + country.toString() + "] закрыта для посещения.");
            }

            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
        } catch (NullPointerException e) {
            /*
             * Выбрасываем исключение, т.к. нет смысла проверять название на русском, если ввод пустой*/
            throw new NullPointerException(". Введено пустое название страны.");
        }

        try {
            Country country = Country.getByRuName(countryName);

            if (country.isOpen()) {
                System.out.println("Страна [" + country.toString() + "] открыта для посещения.");
            } else {
                System.out.println("Страна [" + country.toString() + "] закрыта для посещения.");
            }
        } catch (NoSuchCountryException e) {
            System.out.println("Страны '" + countryName + "' не существует.");
        }

    }
}
