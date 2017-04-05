from rdflib.graph import Graph
from rdflib.compare import to_isomorphic

def dump_nt_sorted(g):
    for l in sorted(g.serialize(format='nt').splitlines()):
        if l: print(l.decode('ascii'))

query1 = Graph().parse(format='nt', data='''
    _:actor <http://www.w3.org/2000/01/rdf-schema#label> "Brad Pitt"@en .
    _:film <http://dbpedia.org/ontology/starring> _:actor .
    _:film <http://www.w3.org/2000/01/rdf-schema#label> _:title .
    _:film <http://dbpedia.org/ontology/director> _:director .
    _:director <http://www.w3.org/2000/01/rdf-schema#label> _:name .
''')

liftres = open("bradres.txt", "r")
query2 = Graph().parse(format='nt', data=liftres.read())

graph1 = to_isomorphic(query1)

graph2 = to_isomorphic(query2)

dump_nt_sorted(graph1)

dump_nt_sorted(graph2)

if (graph1 == graph2): print("Isomorphic")

for s, p, o in graph2:
    if (s, p, o) not in graph1:
        print("une ligne de 2 pas dans 1")

for s, p, o in graph1:
    if (s, p, o) not in graph2:
        print("une ligne de 1 pas dans 2")

