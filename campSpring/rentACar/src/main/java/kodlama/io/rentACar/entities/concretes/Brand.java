package kodlama.io.rentACar.entities.concretes;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "brands")
@Data  //bu bir data barındırır. Bunların getter ve setterlarını oluştr
@AllArgsConstructor
@NoArgsConstructor
@Entity //veritabanı varlığısın ve tablo olarak da buraya kaşılık geliyosun
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String brandName;
	
	@OneToMany(mappedBy = "brand")
	List<Model> models;
}

//colon isimleri ile buradaki isimler farklılık gösterebilir bu nedenle
//@column yapıp kardeşim sen şu column sun deriz
