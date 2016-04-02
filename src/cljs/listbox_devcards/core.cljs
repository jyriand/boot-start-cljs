(ns listbox-devcards.core
  (:require
   [devcards.core :as dc :include-macros true]
   [reagent.core :as reagent]
   [listbox.views :as views])
  (:require-macros [devcards.core :refer [defcard defcard-rg]]))

(enable-console-print!)

(defcard-rg reagent-demo
  (views/home-page))


(defn main []
  (dc/start-devcard-ui!))
