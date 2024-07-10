package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StoreService {
	private List<Products> store;
	private List<Categories> categories;
	
	//costruttore
	public StoreService() {
		this.store = new ArrayList<>();
		this.categories = new ArrayList<>();
		store.add(new Products(1, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", 109.95, "men's clothing", "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday"));
		categories.add(new Categories(1, "men's clothing"));
		store.add(new Products(2, "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet", 695, "jewelery", "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection."));
		categories.add(new Categories(2, "jewelery"));
		store.add(new Products(3, "WD 2TB Elements Portable External Hard Drive - USB 3.0 ", 64, "electronics", "USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system"));
		categories.add(new Categories(3, "electronics"));
		store.add(new Products(4, "BIYLACLESEN Women's 3-in-1 Snowboard Jacket Winter Coats", 56.99, "women's clothing", "Note:The Jackets is US standard size, Please choose size as your usual wear Material: 100% Polyester; Detachable Liner Fabric: Warm Fleece. Detachable Functional Liner: Skin Friendly, Lightweigt and Warm.Stand Collar Liner jacket, keep you warm in cold weather. Zippered Pockets: 2 Zippered Hand Pockets, 2 Zippered Pockets on Chest (enough to keep cards or keys)and 1 Hidden Pocket Inside.Zippered Hand Pockets and Hidden Pocket keep your things secure. Humanized Design: Adjustable and Detachable Hood and Adjustable cuff to prevent the wind and water,for a comfortable fit. 3 in 1 Detachable Design provide more convenience, you can separate the coat and inner as needed, or wear it together. It is suitable for different season and help you adapt to different climates"));
		categories.add(new Categories(4, "women's clothing"));
	}
	
	//mostro tutto lo store
	public List<Products> getStore() {
		return store;
	}
	
	//mostro le categorie
	public List<Categories> getCategories() {
		return categories;
	}
	
	//aggiungo un nuovo prodotto
	public void addProduct(Products prodotto) {
		store.add(prodotto);
		//aggiungo la categoria se non è già presente
		if(categories.stream().noneMatch(c -> c.getName().equals(prodotto.getCategory()))) {
			//l'id della nuova categoria è pari alla lunghezza della lista categories + 1
			categories.add(new Categories(categories.size()+1, prodotto.getCategory()));
		}
	}
	
	//modifico il prodotto
	public boolean updateProduct(int id, Products prodottoNuovo) {
		Optional<Products> existingProduct = store.stream().filter(p -> p.getId()==id).findFirst();
		//controllo se il piatto da modificare è stato trovato
		if (existingProduct.isPresent()) {
			//caso in cui esiste
			Products prod = existingProduct.get();
			prod.setId(prodottoNuovo.getId());
			prod.setTitle(prodottoNuovo.getTitle());
			prod.setPrice(prodottoNuovo.getPrice());
			prod.setCategory(prodottoNuovo.getCategory());
			//controllo che l'update del prodotto non contenga una nuova categoria
			if(categories.stream().noneMatch(c -> c.getName().equals(prod.getCategory()))) {
				//se contiene una nuova categoria la aggiungo
				categories.add(new Categories(categories.size()+1, prodottoNuovo.getCategory()));
			}
			prod.setDescription(prodottoNuovo.getDescription());
			//restituisce true dopo che l'aggiornamento è avvenuto
			return true;
		} else {
			//restituisce false se non è stato trovato il prodotto
			return false;
		}
	}
	
	//elimino il prodotto
	public boolean deleteProduct(int id) {
		return store.removeIf(p -> p.getId()==id);
	}
	
	//aggiungo una categoria
	public void addCategory(Categories categoriaNuova) {
		categories.add(categoriaNuova);
	}
	
	//modifico una categoria
	public boolean updateCategory(int id, Categories categoriaNuova) {
		Optional<Categories> existingCategory = categories.stream().filter(c -> c.getId()==id).findFirst();
		if (existingCategory.isPresent()) {
			Categories cat = existingCategory.get();
			cat.setId(categoriaNuova.getId());
			cat.setName(categoriaNuova.getName());
			return true;
		} else {
			return false;
		}
	}
	
	//elimino una categoria
	public boolean deleteCategory(int id) {
		return categories.removeIf(c -> c.getId()==id);
	}
}
