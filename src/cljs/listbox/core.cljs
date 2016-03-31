(ns listbox.core
  (:require [reagent.core :as r]))

(defonce clicks (r/atom 0))

(defn current-page []
  [:div {:on-click #(swap! clicks inc)}
   "I have been clicked " @clicks " times."])

(defn mount-root []
  (r/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))

(init!)
