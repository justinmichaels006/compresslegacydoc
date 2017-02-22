package com.couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.LegacyDocument;
import com.couchbase.client.java.transcoder.LegacyTranscoder;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;
import com.couchbase.client.java.view.ViewRow;

import java.util.ArrayList;
import java.util.List;

public class CompressLegacyDoc {

        public static void main(String[] args) {

            Bucket myB = ConnectionManager.getConnection();
            Bucket myB2 = ConnectionManager.getConnection2();

            LegacyTranscoder lTrans = new LegacyTranscoder(1);
            List<LegacyDocument> docArray = new ArrayList<>();
            final int MAX_RETRIES = 20000;
            final int RETRY_DELAY = 50;
            final int MAX_DELAY = 1000;
            int i = 0;

            ViewResult result = myB.query(ViewQuery.from("beer", "allkeys"));
            //N1qlQueryResult result2 = myB.query((N1qlQuery.simple("select meta(`beer-sample`).id from `beer-sample`")));

            for (ViewRow row : result) {
                //for (N1qlQueryRow row : result2) {

                JsonDocument jsonDoc = myB.get(row.id());
                LegacyDocument newDoc = LegacyDocument.create(jsonDoc.id(), jsonDoc.content());

                myB2.upsert(newDoc);

                // Build the array of items to load (TODO Batching)
                //docArray.add(i, ldoc2);
                //i = i + 1;
            }

        /*Observable
                .from(docArray)
                .flatMap(doc -> {
                    return myB2.async().upsert(doc)
                            // do retry for each op individually to not fail the full batch
                            .retryWhen(anyOf(BackpressureException.class)
                                    .max(MAX_RETRIES)
                                    .delay(Delay.exponential(TimeUnit.MILLISECONDS, RETRY_DELAY, MAX_DELAY)).build())
                            .retryWhen(anyOf(TemporaryFailureException.class)
                                    .max(MAX_RETRIES)
                                    .delay(Delay.exponential(TimeUnit.MILLISECONDS, RETRY_DELAY, MAX_DELAY)).build());
                }).toBlocking().subscribe(document1 -> {});*/

        /*Observable
                .from(docArray)
                .flatMap(doc -> {return myB2.async().upsert(doc);})
        .toBlocking().subscribe(document1 -> {System.out.println(document1);});*/

            // Decoding what's created
        /*ViewResult result2 = myB2.query(ViewQuery.from("beer", "allkeys"));
        for (ViewRow row : result2) {
            LegacyDocument jsonDoc = lTrans.decode(myB2.get(row.id()).content());
            System.out.println(jsonDoc);
        }*/

            System.out.println("compressed beer sample");
            myB.close();
            myB2.close();

        }
}
