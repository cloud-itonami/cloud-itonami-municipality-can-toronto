# cloud-itonami-municipality-can-toronto

Municipal-ordinance compliance catalog for **Toronto** — the FOURTH
municipality-level entry alongside
[`cloud-itonami-municipality-jpn-tokyo`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-tokyo),
[`cloud-itonami-municipality-usa-washington-dc`](https://github.com/cloud-itonami/cloud-itonami-municipality-usa-washington-dc),
and
[`cloud-itonami-municipality-gbr-london`](https://github.com/cloud-itonami/cloud-itonami-municipality-gbr-london).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the City of
Toronto's behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljc` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries were verified by directly reading the source PDF text
(each is a "CERTIFIED TRUE COPY" digitally signed by the City Clerk):
*Toronto Municipal Code Chapter 545, Licensing* (current text effective
2025-01-01; the overall Municipal Code itself was originally adopted by
City Council 2000-10-03/04/05, in force 2001-01-01) and *Chapter 67,
Fair Wage* (adopted by Council 2024-05-23 via By-law 498-2024, in force
2024-07-01, current text effective 2025-05-01).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Code text itself
remains the City of Toronto's; this repo stores only citation metadata
(id/title/url/dates), not full text.
