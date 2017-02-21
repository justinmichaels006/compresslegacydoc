package com.couchbase;

import com.couchbase.client.core.message.kv.MutationToken;
import com.couchbase.client.java.document.AbstractDocument;

public class LegacyDocument2 extends AbstractDocument<Object> {

    /**
     * Creates a {@link com.couchbase.client.java.document.LegacyDocument} which the document id.
     *
     * @param id the per-bucket unique document id.
     * @return a {@link com.couchbase.client.java.document.LegacyDocument}.
     */
    public static com.couchbase.LegacyDocument2 create(String id) {
        return new com.couchbase.LegacyDocument2(id, 0, null, 0, null);
    }

    /**
     * Creates a {@link com.couchbase.client.java.document.LegacyDocument} which the document id and JSON content.
     *
     * @param id the per-bucket unique document id.
     * @param content the content of the document.
     * @return a {@link com.couchbase.client.java.document.LegacyDocument}.
     */
    public static com.couchbase.LegacyDocument2 create(String id, Object content) {
        return new com.couchbase.LegacyDocument2(id, 0, content, 0, null);
    }

    /**
     * Creates a {@link com.couchbase.client.java.document.LegacyDocument} which the document id, JSON content and the CAS value.
     *
     * @param id the per-bucket unique document id.
     * @param content the content of the document.
     * @param cas the CAS (compare and swap) value for optimistic concurrency.
     * @return a {@link com.couchbase.client.java.document.LegacyDocument}.
     */
    public static com.couchbase.LegacyDocument2 create(String id, Object content, long cas) {
        return new com.couchbase.LegacyDocument2(id, 0, content, cas, null);
    }

    /**
     * Creates a {@link com.couchbase.client.java.document.LegacyDocument} which the document id, JSON content and the expiration time.
     *
     * @param id the per-bucket unique document id.
     * @param expiry the expiration time of the document.
     * @param content the content of the document.
     * @return a {@link com.couchbase.client.java.document.LegacyDocument}.
     */
    public static com.couchbase.LegacyDocument2 create(String id, int expiry, Object content) {
        return new com.couchbase.LegacyDocument2(id, expiry, content, 0, null);
    }

    /**
     * Creates a {@link com.couchbase.client.java.document.LegacyDocument} which the document id, JSON content, CAS value, expiration time and status code.
     *
     * This factory method is normally only called within the client library when a response is analyzed and a document
     * is returned which is enriched with the status code. It does not make sense to pre populate the status field from
     * the user level code.
     *
     * @param id the per-bucket unique document id.
     * @param expiry the expiration time of the document.
     * @param content the content of the document.
     * @param cas the CAS (compare and swap) value for optimistic concurrency.
     * @return a {@link com.couchbase.client.java.document.LegacyDocument}.
     */
    public static com.couchbase.LegacyDocument2 create(String id, int expiry, Object content, long cas) {
        return new com.couchbase.LegacyDocument2(id, expiry, content, cas, null);
    }

    /**
     * Creates a {@link com.couchbase.client.java.document.LegacyDocument} which the document id, JSON content, CAS value, expiration time and status code.
     *
     * This factory method is normally only called within the client library when a response is analyzed and a document
     * is returned which is enriched with the status code. It does not make sense to pre populate the status field from
     * the user level code.
     *
     * @param id the per-bucket unique document id.
     * @param expiry the expiration time of the document.
     * @param content the content of the document.
     * @param cas the CAS (compare and swap) value for optimistic concurrency.
     * @return a {@link com.couchbase.client.java.document.LegacyDocument}.
     */
    public static com.couchbase.LegacyDocument2 create(String id, int expiry, Object content, long cas, MutationToken mutationToken) {
        return new com.couchbase.LegacyDocument2(id, expiry, content, cas, mutationToken);
    }

    /**
     * Creates a copy from a different {@link com.couchbase.client.java.document.LegacyDocument}, but changes the document ID.
     *
     * @param doc the original {@link com.couchbase.client.java.document.LegacyDocument} to copy.
     * @param id the per-bucket unique document id.
     * @return a copied {@link com.couchbase.client.java.document.LegacyDocument} with the changed properties.
     */
    public static com.couchbase.LegacyDocument2 from(com.couchbase.client.java.document.LegacyDocument doc, String id) {
        return com.couchbase.LegacyDocument2.create(id, doc.expiry(), doc.content(), doc.cas(), doc.mutationToken());
    }

    /**
     * Creates a copy from a different {@link com.couchbase.client.java.document.LegacyDocument}, but changes the content.
     *
     * @param doc the original {@link com.couchbase.client.java.document.LegacyDocument} to copy.
     * @param content the content of the document.
     * @return a copied {@link com.couchbase.client.java.document.LegacyDocument} with the changed properties.
     */
    public static com.couchbase.LegacyDocument2 from(com.couchbase.client.java.document.LegacyDocument doc, Object content) {
        return com.couchbase.LegacyDocument2.create(doc.id(), doc.expiry(), content, doc.cas(), doc.mutationToken());
    }

    /**
     * Creates a copy from a different {@link com.couchbase.client.java.document.LegacyDocument}, but changes the document ID and content.
     *
     * @param doc the original {@link com.couchbase.client.java.document.LegacyDocument} to copy.
     * @param id the per-bucket unique document id.
     * @param content the content of the document.
     * @return a copied {@link com.couchbase.client.java.document.LegacyDocument} with the changed properties.
     */
    public static com.couchbase.LegacyDocument2 from(com.couchbase.client.java.document.LegacyDocument doc, String id, Object content) {
        return com.couchbase.LegacyDocument2.create(id, doc.expiry(), content, doc.cas(), doc.mutationToken());
    }

    /**
     * Creates a copy from a different {@link com.couchbase.client.java.document.LegacyDocument}, but changes the CAS value.
     *
     * @param doc the original {@link com.couchbase.client.java.document.LegacyDocument} to copy.
     * @param cas the CAS (compare and swap) value for optimistic concurrency.
     * @return a copied {@link com.couchbase.client.java.document.LegacyDocument} with the changed properties.
     */
    public static com.couchbase.LegacyDocument2 from(com.couchbase.client.java.document.LegacyDocument doc, long cas) {
        return com.couchbase.LegacyDocument2.create(doc.id(), doc.expiry(), doc.content(), cas, doc.mutationToken());
    }

    private LegacyDocument2(String id, int expiry, Object content, long cas, MutationToken mutationToken) {
        super(id, expiry, content, cas, mutationToken);
    }
}

