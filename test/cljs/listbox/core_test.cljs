(ns listbox.core-test
  (:require [listbox.core :as sut]
            [cljs.test :refer-macros [deftest testing is]]))

(deftest numbers-should-equal
  (testing "something different"
    (is (= 2 3))))
