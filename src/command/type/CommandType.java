package command.type;

public enum CommandType
{
    /*
  -d - date(дата)
  -i - index product(индекс продукта) или index food(индекс приема пищи)
  -n - name product(название продукта)
  -w - weight product to grams(вес съеденного в граммах) или постоянный вес продукта
  -e - energy value to kcal(энергетическая ценность в ккал на 100 грамм)
          или энергетическая ценность съеденного
   */
    ADD_FOOD("addFood"),
    // добавить прием пищи - кушать
    //str: addFood -d 24.02.2022 -i 12 -n торт -w 100 -e 186

    //str: addFood -d 24.02.2022 -i 12 -w 100 -e 186
    //str: addFood -i 12 -w 100 -e 186
    //str: addFood -i 12 -w 100

    //str: addFood -d 24.02.2022 -n торт -w 100 -e 186
    //str: addFood -n торт -w 100 -e 186
    //str: addFood -n торт -w 100
    LIST_OF_FOOD("getFood"),
    //вывести табличку о СПИСОК СЪЕДЕННЫХ ПРОДУКТОВ
    //str: getFood - за весь период (-d -i -n -w)
    //str: getFood -d  - за определенную дату(-d -i -n -w)
    DELETE_FOOD("delFood"),
    //удалить прием пищи по индексу приема пищи
    //str: delFood -i

    COUNT_CALORIES_FOOD("getCal"),
    //посчитать и вывести в консоль сколько калорий съедено сегодня
    //str: getCal - сегодня
    //str: getCal -d - за определенную дату
    ADD_PRODUCT("addProd"),
    //добавить продукт, если он уже есть, то обновить ккал
    //str: addProd -n мандарин -e 45
    LIST_OF_PRODUCT("getProd"),
    //вывести табличку о ПРОДУКТАХ
    //str: getProd - за весь период (-i -n -e)
    DELETE_PRODUCT("delProd"),
    //удалить продукт по индексу продукта
    //str: delFood -i - по индексу продукта
    //str: delFood -n - по имени продукта
    ERROR("error") //потом убрать
    ;
    private String command;

    private CommandType (String command)
    {
        this.command = command;
    }

    public String getCommand ()
    {
        return command;
    }

}
