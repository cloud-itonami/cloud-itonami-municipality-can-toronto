(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Toronto -- the FOURTH
  municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london for the first three) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL toronto.ca (legdocs/municode) URL --
  never fabricated. An ordinance not in this table has NO spec-basis,
  full stop; extend `catalog`, do not invent an id/url/number.

  Both entries below were verified by directly reading the source PDF
  text via the Read tool (same strictest-tier verification used for
  several prior entries in this family): each PDF is itself a
  \"CERTIFIED TRUE COPY\" digitally signed by the City Clerk, with a
  visible signing date and, for Chapter 67, an editor's footnote giving
  the by-law's actual coming-into-force date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"toronto"
   [{:ordinance/id "toronto.municipal-code-ch545-licensing"
     :ordinance/title "Toronto Municipal Code Chapter 545, Licensing"
     :ordinance/municipality "toronto"
     :ordinance/country "CAN"
     :ordinance/kind :municipal-code
     :ordinance/number "Chapter 545"
     :ordinance/url "https://www.toronto.ca/legdocs/municode/1184_545.pdf"
     :ordinance/url-provenance :official-toronto-municode
     :ordinance/enacted-date "2001-01-01"
     :ordinance/last-revised-date "2025-01-01"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:licensing}}
    {:ordinance/id "toronto.municipal-code-ch67-fair-wage"
     :ordinance/title "Toronto Municipal Code Chapter 67, Fair Wage"
     :ordinance/municipality "toronto"
     :ordinance/country "CAN"
     :ordinance/kind :municipal-code
     :ordinance/number "Chapter 67 (By-law 498-2024)"
     :ordinance/url "https://www.toronto.ca/legdocs/municode/1184_067.pdf"
     :ordinance/url-provenance :official-toronto-municode
     :ordinance/enacted-date "2024-07-01"
     :ordinance/last-revised-date "2025-05-01"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:labor :fair-wage}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-can-toronto Wave 0 (ADR-2607141700): "
                 (count (get catalog "toronto")) " Toronto entries seeded with "
                 "an official toronto.ca (legdocs/municode) citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
