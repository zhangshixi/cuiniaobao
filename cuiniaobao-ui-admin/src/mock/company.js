import Mock from 'mockjs'
import { param2Obj } from '@/utils'

const List = []
const count = 1000

for (let i = 0; i < count; i++) {
  List.push(Mock.mock({
    companyId: '@increment',
    companyName: '@first',
    companyPhone: '@integer(1, 3)',
    companySite: '@title(5, 10)',
    createDate: '@datetime'
  }))
}

export default {
  getList: config => {
    const { companyId, companyName, companyPhone, page = 1, limit = 10, sort } = param2Obj(config.url)

    let mockList = List.filter(item => {
      if (companyName && item.companyName.indexOf(companyName) < 0) return false
      if (companyPhone && item.companyPhone.indexOf(companyPhone) < 0) return false
      return true
    })

    if (sort === '-companyId') {
      mockList = mockList.reverse()
    }

    const pageList = mockList.filter((item, index) => index < limit * page && index >= limit * (page - 1))

    return {
      total: mockList.length,
      items: pageList
    }
  },
  get: () => ({
    companyId: 11,
    companyName: '原创作者',
    companyPhone: '95555',
    companySite: '我是测试数据',
    createDate: +new Date()
  }),
  create: () => ({
    data: 'success'
  }),
  update: () => ({
    data: 'success'
  })
}
