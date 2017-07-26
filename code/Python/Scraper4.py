import sys
from pprint import pprint
from scrapemark import scrape

pprint(scrape("""
    <table class="spad">
        <tbody>
            {*
                <tr>
                    <td>{{[].day}}</td>
                    <td>{{[].sunrise}}</td>
                    <td>{{[].sunset}}</td>
                    {# ... #}
                </tr>
            *}
        </tbody>
    </table>
""", url=sys.argv[1] ))
