package com.example.pokedex.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Makeup implements Parcelable {

    private int id;
    private double price_sign, rating;
    private String brand, name, price, currency, image_link, product_link, website_link, description, category, product_type, created_at, updated_at, product_api_url, api_featured_image;
    private String[] tag_list;
    private Color[] product_colors;

    protected Makeup(Parcel in) {
        id = in.readInt();
        price = in.readString();
        price_sign = in.readDouble();
        rating = in.readDouble();
        brand = in.readString();
        name = in.readString();
        currency = in.readString();
        image_link = in.readString();
        product_link = in.readString();
        website_link = in.readString();
        description = in.readString();
        category = in.readString();
        product_type = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        product_api_url = in.readString();
        api_featured_image = in.readString();
        tag_list = in.createStringArray();
        //product_colors = in.createStringArray();
    }

    public static final Creator<Makeup> CREATOR = new Creator<Makeup>() {
        @Override
        public Makeup createFromParcel(Parcel in) {
            return new Makeup(in);
        }

        @Override
        public Makeup[] newArray(int size) {
            return new Makeup[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getPrice_sign() {
        return price_sign;
    }

    public void setPrice_sign(double price_sign) {
        this.price_sign = price_sign;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getProduct_link() {
        return product_link;
    }

    public void setProduct_link(String product_link) {
        this.product_link = product_link;
    }

    public String getWebsite_link() {
        return website_link;
    }

    public void setWebsite_link(String website_link) {
        this.website_link = website_link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getProduct_api_url() {
        return product_api_url;
    }

    public void setProduct_api_url(String product_api_url) {
        this.product_api_url = product_api_url;
    }

    public String getApi_featured_image() {
        return api_featured_image;
    }

    public void setApi_featured_image(String api_featured_image) {
        this.api_featured_image = api_featured_image;
    }

    public String[] getTag_list() {
        return tag_list;
    }

    public void setTag_list(String[] tag_list) {
        this.tag_list = tag_list;
    }

    public Color[] getProduct_colors() {
        return product_colors;
    }

    public void setProduct_colors(Color[] product_colors) {
        this.product_colors = product_colors;
    }

    @Override
    public String toString() {
        return "$" + price +
                "\n" + name.toUpperCase();
    }//Fin toString

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(price);
        dest.writeDouble(price_sign);
        dest.writeDouble(rating);
        dest.writeString(brand);
        dest.writeString(name);
        dest.writeString(currency);
        dest.writeString(image_link);
        dest.writeString(product_link);
        dest.writeString(website_link);
        dest.writeString(description);
        dest.writeString(category);
        dest.writeString(product_type);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeString(product_api_url);
        dest.writeString(api_featured_image);
        dest.writeStringArray(tag_list);
        //dest.writeStringArray(product_colors);
    }//Fin writeToParcel

}//Fin clase Makeup
