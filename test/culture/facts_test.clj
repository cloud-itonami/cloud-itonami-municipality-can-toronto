(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest toronto-has-culture-basis
  (let [sb (facts/spec-basis "toronto")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "toronto" (:culture/municipality %)) sb))
    (is (every? #(= "CAN" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "montreal")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["toronto" "montreal"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["montreal"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 3 (count (facts/by-kind "toronto" :dish))))
  (is (= ["toronto.beverage.toronto-cocktail"]
         (mapv :culture/id (facts/by-kind "toronto" :beverage))))
  (is (empty? (facts/by-kind "toronto" :craft)))
  (is (empty? (facts/by-kind "montreal" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
