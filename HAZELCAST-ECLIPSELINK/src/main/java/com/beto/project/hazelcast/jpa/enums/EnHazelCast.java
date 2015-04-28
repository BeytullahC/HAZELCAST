package com.beto.project.hazelcast.jpa.enums;

/**
 * Created by 912867 on 28.04.2015.
 */
public enum EnHazelCast {
    COUNTRIES {
        public String toString() {
            return "countries";
        }
    },
    JOBS {
        public String toString() {
            return "jobs";
        }
    },
    EMPLOOYES {
        public String toString() {
            return "emplooyes";
        }
    };
}
