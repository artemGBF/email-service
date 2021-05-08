<#ftl encoding="UTF-8">
<h1>Спасибо за заказ!</h1>
<p>Номер заказа: ${data.number}</p>
<ul>
    <#list data.items as item>
        <li>
            наименование: ${item.name}, цена: ${item.price}, количество: ${item.count}
        </li>
    </#list>
</ul>
<p>Способ доставки: ${data.delivery}</p>
<p>Сумма заказа: ${data.total}</p>