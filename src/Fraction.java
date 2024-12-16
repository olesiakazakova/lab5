public class Fraction implements FractionInterface {
    //поля
    private int numerator;
    private int denominator;
    private Double cachedValue;
    //свойства
    public int getNumerator() {
        return this.numerator;
    }
    public int getDenominator() {
        return this.denominator;
    }
    //получение вещ значения
    @Override
    public double getValue() {
        if (this.cachedValue == null) {
            this.cachedValue = (double) numerator / denominator;
        }
        return this.cachedValue;
    }
    //конструктор
    public Fraction (int numerator, int denominator) {
        setFraction(numerator, denominator);
    }
    //методы
    public String toString () {
        return this.numerator + "/" + this.denominator;
    }
    @Override
    public boolean equals(Object o) {
        // Проверяем, ссылается ли объект на сам себя
        if (this == o) return true;
        // Проверяем, является ли объект экземпляром Fraction
        if (o == null || getClass() != o.getClass()) return false;
        // Приводим объект к типу Fraction
        Fraction a = (Fraction) o;
        // Сравниваем
        return this.numerator == a.getNumerator() && this.denominator == a.getDenominator();
    }
    // Установка числителя и знаменателя
    @Override
    public void setFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        if (denominator < 0) {
            this.numerator = (-1)*this.numerator;
        } else this.numerator = numerator;
        this.denominator = Math.abs(denominator);
        this.cachedValue = null;
    }
}
