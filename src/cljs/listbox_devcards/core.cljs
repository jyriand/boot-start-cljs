(ns listbox-devcards.core
  (:require
   [devcards.core :as dc :include-macros true]
   [reagent.core :as reagent]
   [listbox.views :as views])
  (:require-macros [devcards.core :refer [defcard defcard-rg deftest tests]]
                   [cljs.test :refer [is testing async]]))

(enable-console-print!)

(defcard-rg reagent-demo
  (views/home-page))

(deftest demo-test
  (testing "good stuff"
    (is (= 1 1))))

(defcard create-something
  (tests
   "Creates something and then ahsda"
   (let [name "jaskd"]
     (is (= "jaskd" name)))))

(defn say-hello []
  (println "Hello from file"))

(defn main []
  (dc/start-devcard-ui!))
