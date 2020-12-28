(ns gas-app.core
  (:require [gas-app.entry-points]))

(defn ^:export main []
  (.log js/console "Hello cljs from gas with clasp"))
