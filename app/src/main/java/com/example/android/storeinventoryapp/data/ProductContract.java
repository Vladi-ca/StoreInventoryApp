package com.example.android.storeinventoryapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Vladi on 27.7.17.
 */

/**
 * API Contract for the inventory app.
 */
public final class ProductContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private ProductContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.android.storeinventoryapp";

    // Next, we concatenate the CONTENT_AUTHORITY constant with the scheme “content://” we will create
    // the BASE_CONTENT_URI which will be shared by every URI associated with ProductContract:
    // To make this a usable URI, we use the parse method which takes in a URI string and returns a Uri.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // This constants stores the path for each of the tables which will be appended to the base content URI.
    public static final String PATH_PRODUCTS = "products";

    /**
     * Inner class that defines constant values for the products database table.
     * Each entry in the table represents a single product.
     */
    public static final class ProductEntry implements BaseColumns {

        // Lastly, inside each of the Entry classes in the contract, we create a full URI for the class as a
        // constant called CONTENT_URI. The Uri.withAppendedPath() method appends the BASE_CONTENT_URI
        // (which contains the scheme and the content authority) to the path segment.
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCTS);

        // MIME - To implement this behavior in our PetProvider, we should first declare constants
        // representing the MIME types in our PetContract file, within the PetEntry class. The very
        // subtle difference is in the word after cursor: either “dir” or “item”.
        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of products.
         */
        // we’re making use of the constants defined ContentResolver class
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single product.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        /**
         * Name of database table for products
         */
        public final static String TABLE_NAME = "inventory";

        /**
         * Unique ID number for the product (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the product.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_PRODUCT_NAME = "product";

        /**
         * Price of the pr.
         */
        public final static String COLUMN_PRODUCT_PRICE = "price";

        /**
         * Quantity of the pr.
         */
        public final static String COLUMN_PRODUCT_QUANTITY = "quantity";

        /**
         * Supplier name
         */
        public final static String COLUMN_PRODUCT_SUPPLIER = "supplier";

        /**
         * Supplier email
         */
        public final static String COLUMN_PRODUCT_EMAIL = "email";

        /**
         * Product image
         */
        public final static String COLUMN_PRODUCT_IMAGE = "image";

    }
}