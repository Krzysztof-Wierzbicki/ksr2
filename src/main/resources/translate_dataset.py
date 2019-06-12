#!/usr/bin/python3
"""
Run with working directory = resources
"""

def race(code):
    if code == '5':
        result = 'white'
    elif code == '4':
        result = 'black'
    elif code == '6':
        result = 'hispanic'
    else:
        result = 'other'

    return result


def mar_stat(code):
    return {
        '1': 'married',
        '2': 'informal relationship',
        '3': 'widowed',
        '4': 'divorced',
        '5': 'separated',
        '6': 'never married'
    }[code]


def school(code):
    int_code = int(code[0:2])
    result = {}
    if 9 <= int_code <= 12:
        result['type'] = 'school'
        result['value'] = int_code
    elif int_code <= 19:
        result['type'] = 'college'
        result['value'] = int_code - 12
    else:
        raise KeyError()

    if code[2] == '1':
        result['completed'] = True
    elif code[2] == '5':
        result['completed'] = False
    else:
        raise KeyError()

    return '{},{},{}'.format(result['type'], result['value'], result['completed'])


def degree(code):
    return {
        ' ': 'None',
        '1': 'Associate',
        '2': 'Bachelor',
        '3': 'Master',
        '4': 'Doctorate',
        '5': 'Professional'
    }[code]


def religion(code):
    return {
        ' 1': 'None',
        ' 2': 'catholic',
        ' 3': 'baptist',
        ' 4': 'protestant',
        ' 5': 'protestant',
        ' 6': 'protestant',
        ' 7': 'protestant',
        ' 8': 'other'
    }[code]


def int_cutoff(code):
    try:
        value = int(code)
    except ValueError:
        return None
    if value > 25:
        return None
    return value


def yes_no(code):
    return {
        '1': True,
        '5': False
    }[code]


def work(code):
    return {
        ' ': 'None',
        '1': 'full-time',
        '2': 'part-time',
        '3': 'both'
    }[code]


def weight(code):
    """
    Wartosci od 47 do 125 kg
    """
    if code == '   ':
        return None
    pounds = int(code)
    if pounds >= 997:
        return None
    return int(round(pounds*0.453592, 0))

def height(code):
    """
    149 to 181 cm
    """
    if code == '  ' or code == '96':
        return None
    return int(round(int(code)*2.54, 0))


def earn(code):
    """
    Roczne zarobki - poniżej podanego progu, poza ostatnim oznaczającym powyżej 75000$
    """
    return {
        '  ': None,
        ' 1': 5000,
        ' 2': 7500,
        ' 3': 10000,
        ' 4': 12500,
        ' 5': 15000,
        ' 6': 20000,
        ' 7': 25000,
        ' 8': 30000,
        ' 9': 35000,
        '10': 40000,
        '11': 50000,
        '12': 60000,
        '13': 75000,
        '14': 2137000
    }[code]


file_description = [
    #name, start, end, type
    ('id', 0, 4, int),
    ('race', 9, 9, race),
    ('age', 18, 19, int),
    ('marital status', 20, 20, mar_stat),
    ('kids no', 31, 31, int),
    ('school type,maxgrade,comleted', 38, 40, school),
    ('degree', 68, 68, degree),
    ('pregnancy count', 101, 102, int_cutoff),
    ('marriage count', 726, 727, int_cutoff),
    ('religion', 4727, 4728, religion),
    ('ever worked', 4736, 4736, yes_no),
    ('work type', 4750, 4750, work),
    ('weight (kg)', 4815, 4817, weight),
    ('height (cm)', 4818, 4819, height),
    ('earnings ($)', 4823, 4824, earn)
]

def main():
    with open('2006_2010_FemResp.dat') as data, open('data.csv', 'w+') as output:
        line_str = ''
        for desc in file_description:
            line_str += desc[0] + ','
        output.write(line_str[:-1] + '\n')
        dc = 0
        added = 0
        for line in data:
            try:
                line_str = ''
                for name, start, stop, func in file_description:
                    line_str += str(func(line[start:stop+1])) + ','
                output.write(line_str[:-1] + '\n')
                added += 1
            except KeyError:
                dc += 1
                continue
        print('Lines added:', added)
        print('Lines discarded:', dc)


if __name__ == '__main__':
    main()