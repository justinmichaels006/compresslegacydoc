package com.couchbase;

import com.couchbase.client.core.retry.FailFastRetryStrategy;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.Document;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.couchbase.client.java.transcoder.LegacyTranscoder;
import com.couchbase.client.java.transcoder.Transcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectionManager {

    public static final int MAX_RETRIES = 3;
    public static final String bucketName = "beer-sample"; // more elegant use of bucket name
    public static final String bucketName2 = "beers";
    public static final String bucketPassword = "";
    public static final List<String> nodes = Arrays.asList("10.112.151.101"); //dnssrv entry here

    public static Bucket getConnection() {
        CouchbaseEnvironment environment = DefaultCouchbaseEnvironment.builder()
                .dnsSrvEnabled(false)
                .kvEndpoints(2) //if you have batch upload can gain throughput
                // but with small operations can cause contention with socket overhead
                .computationPoolSize(4) // very rare needed to be changed
                //.queryEndpoints(2) // long running N1QL queries
                //.observeIntervalDelay()
                .retryStrategy(FailFastRetryStrategy.INSTANCE) // only needed in demanding cache-only use case
                .build();
        CouchbaseCluster cluster = CouchbaseCluster.create(environment, nodes);

        List<Transcoder<? extends Document, ?>> transcoders = new ArrayList<>();
        transcoders.add(new LegacyTranscoder(0));

        final Bucket bucket = cluster.openBucket(bucketName, "", transcoders);

        return bucket;
    }

    public static Bucket getConnection2() {
        CouchbaseEnvironment environment = DefaultCouchbaseEnvironment.builder()
                .dnsSrvEnabled(false)
                .kvEndpoints(2) //if you have batch upload can gain throughput
                // but with small operations can cause contention with socket overhead
                .computationPoolSize(4) // very rare needed to be changed
                //.queryEndpoints(2) // long running N1QL queries
                //.observeIntervalDelay()
                .retryStrategy(FailFastRetryStrategy.INSTANCE) // only needed in demanding cache-only use case
                .build();
        CouchbaseCluster cluster = CouchbaseCluster.create(environment, nodes);

        List<Transcoder<? extends Document, ?>> transcoders = new ArrayList<>();
        transcoders.add(new LegacyTranscoder(0));

        final Bucket bucket = cluster.openBucket(bucketName2, "", transcoders);

        return bucket;
    }
}
