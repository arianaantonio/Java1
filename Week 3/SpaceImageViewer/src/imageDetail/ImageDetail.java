package imageDetail;

//Ariana Antonio
//Java 1, Week 1, Full Sail University, MDVBS
//06/10/2014

public enum ImageDetail {
	//create static image details
	M106("Spiral Galaxy M106", "http://www.astrobin.com/100974/0/rawthumb/gallery/", "astroman133", "Tele Vue NP 127i"),
		 
	M100("M100 - Spiral galaxy in Virgo", "http://www.astrobin.com/100346/0/rawthumb/gallery/", "Stellario", "Bresser Messier NT203/1000"),
		 
	NGC6503("NGC 6503 Dwarf Spiral in Draco", "http://www.astrobin.com/98874/0/rawthumb/gallery/", "jaddbd", "Astro-Tech AT10RCCF0"),
	
	NGC2841("Flocculent spiral galaxy NGC2841", "http://www.astrobin.com/98725/0/rawthumb/gallery/", "apricot", "Teleskop Service - Orion Optics TS 8"),
	
	NGC6255("ngc 6255 - Barred Spiral in Hercules", "http://www.astrobin.com/98188/0/rawthumb/gallery", "astroeyes", "Orion Optics UK DX 250");
	

		 
	//set strings
	private final String imageTitle;
	private final String imageURL;
	private final String imageUser;
	private final String imageTelescope;
		 
		 //Set the string to enum methods
		 private ImageDetail(String imageTitle, String imageURL, String imageUser, String imageTelescope){
		     this.imageTitle = imageTitle;
		     this.imageURL = imageURL;
		     this.imageUser = imageUser;
		     this.imageTelescope = imageTelescope;
		 }
		 
		 //get values
		 public String getImageTitle() {
		     return imageTitle;
		 }
		 
		 public String getImageURL() {
		     return imageURL;
		 }
		 public String getImageUser() {
			 return imageUser;
		 }
		 public String getImageTelescope() {
			 return imageTelescope;
		 }
}
