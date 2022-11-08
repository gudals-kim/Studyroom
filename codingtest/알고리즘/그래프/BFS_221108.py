def bfs(graph, start_node):
    result = list()
    visite = list()
    visite.append(start_node)

    while visite:
        node = visite.pop(0)
        if node not in result:
            result.append(node)
            visite.extend(graph[node])
    return result

#그래프 정의
graph = dict()
graph['A'] = ['B','C']
graph['B'] = ['A', 'D']
graph['C'] = ['A', 'G', 'H', 'I']
graph['D'] = ['B', 'E', 'F']
graph['E'] = ['D']
graph['F'] = ['D']
graph['G'] = ['C']
graph['H'] = ['C']
graph['I'] = ['C', 'J']
graph['J'] = ['I']

print(bfs(graph, "A"))