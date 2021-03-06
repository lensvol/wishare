(ns wishare.handler-test
  (:require [clojure.test :refer :all]
            [wishare.handler :refer :all]
            [ring.mock.request :as mock]
            [expectations :refer [expect]]))

(expect 200
        (let [response (app (mock/request :get "/"))]
          (:status response)))

(expect 302
        (let [response (app (mock/request :get "/signin"))]
          (:status response)))
