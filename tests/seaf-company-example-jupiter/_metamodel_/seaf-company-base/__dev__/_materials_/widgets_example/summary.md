{{#.}}
```markuper-form-label
{{ &title }}
```
{{#data}}
{{#link.length}}
{{#link}}
[```{{ &content }}```]{{&.}}
{{/link}}
{{/link.length}}
{{^link.length}}
```markuper-form-field
{{ &content }}
```
{{/link.length}}

{{/data}}
{{/.}}