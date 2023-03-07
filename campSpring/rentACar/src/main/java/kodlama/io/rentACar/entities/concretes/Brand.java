package kodlama.io.rentACar.entities.concretes;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "brands")
@Data  //bu bir data barındırır. Bunların getter ve setterlarını oluştr
@AllArgsConstructor
@NoArgsConstructor
//@Entity //veritabanı varlığısın ve tablo olarak da buraya kaşılık geliyosun
public class Brand {
	private int id;
	private String name;
}
