<%
    ui.decorateWith("appui", "standardEmrPage", [title: "MCH Drug Transactions"])
    ui.includeJavascript("billingui", "moment.js")
    ui.includeCss("uicommons", "datatables/dataTables_jui.css")
    ui.includeJavascript("patientqueueapp", "jquery.dataTables.min.js")
%>

<div class="clear"></div>

<div>
    <div class="example">
        <ul id="breadcrumbs">
            <li>
                <a href="${ui.pageLink('referenceapplication', 'home')}">
                    <i class="icon-home small"></i></a>
            </li>

            <li>
                <i class="icon-chevron-right link"></i>
                <a href="${ui.pageLink('mchapp', 'stores')}">MCH Stores</a>
            </li>

            <li>
                <i class="icon-chevron-right link"></i>
                ${title}
            </li>
        </ul>
    </div>
</div>

<% storeDrugs.each { %>
<table>
    <thead>
    <tr>
        <th>Batch No.</th>
        <th>${it.batchNo}</th>
        <th>Current Qnty:</th>
        <th>${it.currentQuantity}</th>
        <th>Expiry Date:</th>
        <th>${it.expiryDate}</th>
        <th><i class="small right chevron icon-chevron-right" data-idnt="${it.batchNo}" data-name="${it.batchNo}"
               data-prog="${it.batchNo}"></i></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td colspan="7"></td>
    </tr>

    </tbody>
</table>

<% } %>