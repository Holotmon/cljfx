(ns cljfx.fx.tab-pane
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce]
            [cljfx.fx.control :as fx.control])
  (:import [javafx.scene.control TabPane TabPane$TabClosingPolicy TabPane$TabDragPolicy]
           [javafx.geometry Side]))

(def lifecycle
  (lifecycle.composite/describe TabPane
    :ctor []
    :extends [fx.control/lifecycle]
    :props {:rotate-graphic [:setter lifecycle/scalar :default false]
            :side [:setter lifecycle/scalar :coerce (coerce/enum Side) :default :top]
            :tab-closing-policy [:setter lifecycle/scalar
                                 :coerce (coerce/enum TabPane$TabClosingPolicy)
                                 :default :selected-tab]
            :tab-drag-policy [:setter lifecycle/scalar
                              :coerce (coerce/enum TabPane$TabDragPolicy) :default :fixed]
            :tab-max-height [:setter lifecycle/scalar :coerce double :default Double/MAX_VALUE]
            :tab-max-width [:setter lifecycle/scalar :coerce double :default Double/MAX_VALUE]
            :tab-min-height [:setter lifecycle/scalar :coerce double :default 0.0]
            :tab-min-width [:setter lifecycle/scalar :coerce double :default 0.0]
            :tabs [:list lifecycle/dynamics]}))