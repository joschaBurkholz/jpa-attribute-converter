# jpa-attribute-converter

#### Summary
Use the jpa-attribute-converter to convert between Java objects (for now ``java.time.year``) and the presentation in a database.<br>
Since Hibernate would store the serialized object, it is hard to debug.

#### Usage


```
import java.time.Year;
import javax.persistence.Entity;
import javax.persistence.Convert;
 
import de.joscha_burkholz.jpa_attribute_converter.YearConverter;
 
@Entity
public class MyEntity {
 
    @Convert(converter = YearConverter.class)
    private Year year;
    
    // getter/setter omitted
}
```
