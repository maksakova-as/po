{{#.}}
{{#field_content.value}}
```markuper-form-label
{{ field_name }}
```
{{#field_content.link}}

[``` {{{ field_content.value }}} ```]({{field_content.link}})
{{/field_content.link}}

{{^field_content.link}}
```markuper-form-field
{{{ field_content.value }}}
```
{{/field_content.link}}
{{/field_content.value}}
{{/.}}