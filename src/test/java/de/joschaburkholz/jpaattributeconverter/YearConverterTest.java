package de.joschaburkholz.jpaattributeconverter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Year;

import org.junit.Test;

public class YearConverterTest {

    private static final YearConverter YEAR_CONVERTER = new YearConverter();

    @Test
    public void test_convertToDatabaseColumn() throws Exception {
        Year year = Year.of(2017);

        String yearString = YEAR_CONVERTER.convertToDatabaseColumn(year);

        assertThat(yearString).isEqualTo("2017");
    }

    @Test
    public void test_convertToDatabaseColumn_yearIsNull() throws Exception {
        Year year = null;

        String yearString = YEAR_CONVERTER.convertToDatabaseColumn(year);

        assertThat(yearString).isNull();
    }

    @Test
    public void test_convertToEntityAttribute() throws Exception {
        String yearString = "2017";

        Year year = YEAR_CONVERTER.convertToEntityAttribute(yearString);

        assertThat(year).isEqualTo(Year.of(2017));
    }

    @Test
    public void test_convertToEntityAttribute_yearIsNull() throws Exception {
        String yearString = null;

        Year year = YEAR_CONVERTER.convertToEntityAttribute(yearString);

        assertThat(year).isNull();
    }

    @Test
    public void test_convertToEntityAttribute_invalidInput() throws Exception {
        String yearString = "InvalidYearString";

        assertThatThrownBy(() -> YEAR_CONVERTER.convertToEntityAttribute(yearString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("InvalidYearString is not a valid value.");

    }

}
