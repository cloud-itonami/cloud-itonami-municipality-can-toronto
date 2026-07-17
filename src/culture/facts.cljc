(ns culture.facts
  "Regional-culture catalog for Toronto -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"toronto"
   [{:culture/id "toronto.dish.peameal-bacon-sandwich"
     :culture/name "Peameal bacon sandwich"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :dish
     :culture/summary "Sandwich of wet-cured, cornmeal-rolled pork loin bacon originated by William Davies in Toronto in the 1850s; often considered a signature dish of Toronto, particularly from St. Lawrence Market."
     :culture/url "https://en.wikipedia.org/wiki/Peameal_bacon"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "toronto.dish.butter-tart"
     :culture/name "Butter tart"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :dish
     :culture/summary "Small pastry tart highly regarded in Canadian cuisine and a cultural icon particularly in Ontario, Toronto's province; filled with butter, brown sugar and egg."
     :culture/url "https://en.wikipedia.org/wiki/Butter_tart"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "toronto.dish.jamaican-patty"
     :culture/name "Jamaican patty"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :dish
     :culture/summary "Jamaican-origin filled pastry that became significant to Toronto's cultural history through the 1985 'patty wars', when local vendors resisted a government attempt to ban the name 'beef patty'."
     :culture/url "https://en.wikipedia.org/wiki/Jamaican_patty"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "toronto.beverage.toronto-cocktail"
     :culture/name "Toronto"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :beverage
     :culture/summary "Dry, rich and mildly bitter cocktail of rye whisky, Fernet-Branca, bitters and sugar, named after the city of Toronto and first documented in 1922 as a drink appreciated by Torontonians."
     :culture/url "https://en.wikipedia.org/wiki/Toronto_(cocktail)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "toronto.festival.toronto-caribbean-carnival"
     :culture/name "Toronto Caribbean Carnival"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :festival
     :culture/summary "Festival of Caribbean culture and traditions held each summer in Toronto over multiple weeks in July and early August, culminating during the Simcoe Day long weekend."
     :culture/url "https://en.wikipedia.org/wiki/Toronto_Caribbean_Carnival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "toronto.festival.toronto-international-film-festival"
     :culture/name "Toronto International Film Festival"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :festival
     :culture/summary "One of the largest publicly attended film festivals in the world, founded in 1976 and held annually in early September in downtown Toronto."
     :culture/url "https://en.wikipedia.org/wiki/Toronto_International_Film_Festival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "toronto.heritage.cn-tower"
     :culture/name "CN Tower"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :heritage
     :culture/summary "553.3-metre communications and observation tower in Toronto, completed in 1976; an iconic landmark of the city."
     :culture/url "https://en.wikipedia.org/wiki/CN_Tower"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "toronto.heritage.casa-loma"
     :culture/name "Casa Loma"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :heritage
     :culture/summary "Gothic Revival castle-style mansion and garden in midtown Toronto, constructed 1911-1914 as a residence for financier Sir Henry Pellatt."
     :culture/url "https://en.wikipedia.org/wiki/Casa_Loma"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "toronto.heritage.distillery-district"
     :culture/name "Distillery District"
     :culture/municipality "toronto"
     :culture/country "CAN"
     :culture/kind :heritage
     :culture/summary "Commercial and residential district east of downtown Toronto with over forty Victorian-era industrial buildings, designated a National Historic Site of Canada in 1988."
     :culture/url "https://en.wikipedia.org/wiki/Distillery_District"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-can-toronto culture catalog "
                 "(ADR-2607171400): " (count (get catalog "toronto"))
                 " Toronto entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
