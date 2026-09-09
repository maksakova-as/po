{{#show_refs}}

| № | Материал | Комментарий  |
|---|----------|--------------|
{{#refs}}
{{#ref_link}}
|{{number}}|[{{ref_title}}]({{ref_link}}) | {{comment}}|
{{/ref_link}}
{{^ref_link}}
|{{number}}|{{ref_title}} | {{comment}}|
{{/ref_link}}
{{/refs}}

{{/show_refs}}