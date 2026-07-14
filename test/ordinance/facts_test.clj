(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest toronto-has-spec-basis
  (let [sb (facts/spec-basis "toronto")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.toronto.ca/") sb))
    (is (every? #(= :municipal-code (:ordinance/kind %)) sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "ottawa")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["toronto" "ottawa"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ottawa"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["toronto.municipal-code-ch67-fair-wage"]
         (mapv :ordinance/id (facts/by-topic "toronto" :fair-wage))))
  (is (empty? (facts/by-topic "toronto" :data-protection)))
  (is (empty? (facts/by-topic "ottawa" :licensing))))
