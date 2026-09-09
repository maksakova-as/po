{% jsonata
(
  $rows := docs.ta.metamodel.properties[entity_id = "seaf.ta.services.k8s" or entity_id = "seaf.ta.services.entity"];
  $entity_name := $rows[entity_id = "seaf.ta.services.k8s"][0].entity_title ? $rows[entity_id = "seaf.ta.services.k8s"][0].entity_title : "Kubernetes service";
  $scope_names := {
    "core": "Общие параметры",
    "entity": "Экземпляр сервиса",
    "schema": "Глобальные свойства",
    "base": "Базовый блок",
    "physical": "Физические параметры",
    "virtual": "Виртуальные параметры",
    "dzo": "ДЗО расширения"
  };
  $scope_summary := $distinct($rows.scope).(
    "| " &
    ($lookup($scope_names, $) ? $lookup($scope_names, $) : $) &
    " | " &
    $count($rows[scope = $]) &
    " |"
  ) ~> $join("\n");
  $group_keys := $distinct($rows.(definition & "::" & entity_id));
  $groups := $group_keys.(
    $parts := $split($, "::");
    $group_id := $parts[0];
    $group_entity := $parts[1];
    $group_rows := $rows[definition = $group_id and entity_id = $group_entity];
    $group_name := $group_rows[0].definition_title ? $group_rows[0].definition_title : $group_id;
    $entity_badge := $group_entity = "seaf.ta.services.entity" ? " *(базовая сущность)*" : "";
    "### " & $group_name & $entity_badge & "\n" &
    $group_rows.(
      $scope_badge :=
        scope = "dzo" ? " `[DZO]`"
        : (
            scope = "base" ? " `[Base]`"
            : (
                scope = "physical" ? " `[Physical]`"
                : (
                    scope = "virtual" ? " `[Virtual]`"
                    : ""
                  )
              )
          );
      $required_label := required ? " *(обязательно)*" : " *(опционально)*";
      $enum_block := enum ? ("  \n    Enum: " & enum) : "";
      $links_block := $exists(links[0])
        ? ("  \n    Связи: " & links.("[[" & link & " " & title & "]]") ~> $join(", ") )
        : "";
      "- **" & property & "** — " &
      (title ? title : "Без названия") &
      (description ? ". " & description : "") &
      " _(тип: " & (type ? type : "n/a") & " )_" &
      $required_label & $scope_badge &
      $enum_block & $links_block
    ) ~> $join("\n")
  ) ~> $join("\n\n");
  "# " & $entity_name & ": свойства\n\n" &
  "> DOC_ID: docs.ta.entity.k8s.properties_table\n\n" &
  "> Данные собираются динамически из seaf.ta.*\n\n" &
  "| Категория | Свойств |\n| --- | --- |\n" & $scope_summary & "\n\n" &
  $groups
)
%}
