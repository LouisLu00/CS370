<script setup>
import { useRoute, useRouter } from 'vue-router';
import { ref, onMounted } from 'vue';
import { ElLoading, ElMessageBox, ElMessage } from 'element-plus';
import TopButton from '../../components/top_button.vue';
import GridIngredient from '../../components/grid_ingredient.vue'

const route = useRoute();
const router = useRouter();

const email = ref('');
const password = ref('');
const items = ref([]);

onMounted(async () => {
  email.value = route.query.email || '';
  password.value = route.query.password || '';
  await fetchData();
});

const fetchData = async () => {
  try {
    let uid = 1234
    const response = await fetch(`http://localhost:5050/fridge/list/${uid}`);
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data = await response.json();
    items.value = data;
  } catch (error) {
    console.error('Error fetching data:', error);
  }
};

const navigateToManualPage = () => {
  localStorage.setItem('edit_type', 'manual');
  router.push({
    path: '/edit_ingredient'
  });
};

const navigateToRecommendation = () => {
  // console.log(items);
  router.push({
    path: '/recommend',
    query: {fridge: JSON.stringify(items.value)}
  });
};

const navigateToCreator = () => {
  router.push({
    path: '/creator_recipe'
  });
};

const fileInput = ref(null);

const navigateToCameraPage = () => {
  fileInput.value.click();
};

const handleFileChange = async (event) => {
  const file = event.target.files[0];
  if (file) {
    try {
      const loadingInstance = ElLoading.service({
        fullscreen: true
      });

      const formData = new FormData();
      formData.append('file', file);

      const response = await fetch('http://localhost:5050/rekognition/detectLabels', {
        method: 'POST',
        body: formData
      });

      loadingInstance.close();

      if (response.ok) {
        const labels = await response.json();
        router.push({ path: '/camera_result', query: { labels: labels } });
        // showLabelsMessageBox(labels);
      } else {
        console.error('Failed to detect labels:', response.statusText);
        ElMessageBox.alert('Recognition failed. Please try again.', 'Message', {
          confirmButtonText: 'OK',
          type: 'error'
        });
      }
    } catch (error) {
      console.error('Error processing image:', error);
      ElMessageBox.alert('Error processing image. Please try again.', 'Message', {
        confirmButtonText: 'OK',
        type: 'error'
      });
    }
  }
};

const showLabelsMessageBox = (labels) => {
  console.log(labels)
  if (labels.length <= 20) {
    ElMessageBox.alert('Recognition result: ' + labels.join('</br>'), 'Message', {
      confirmButtonText: 'OK',
      dangerouslyUseHTMLString: true,
      type: 'success'
    });
  } else {
    ElMessageBox.alert('Too many labels. Please choose another way to view.', 'Message', {
      confirmButtonText: 'OK',
      type: 'info'
    });
  }
};

const handleDelete = async (index) => {
  console.log(items.value[index]);
  try {
    const id = items.value[index].id;
    const response = await fetch(`http://localhost:5050/fridge/${id}`, {
      method: 'DELETE',
    });
    if (response.ok) {
      const data = await response.text();
      ElMessage.success(data);
      items.value.splice(index, 1);
    } else {
      throw new Error('Failed to delete');
    }
  } catch (error) {
    console.error('Failed to delete:', error);
    ElMessage.error('Failed to delete');
  }
};

const handleEdit = (index) => {
  const itemToEdit = items.value[index];
  // console.log(itemToEdit);
  // console.log(index);
  localStorage.setItem('edit_type', 'edit');
  sessionStorage.setItem('ingredient', JSON.stringify(itemToEdit));

  router.push({
    name: 'edit_ingredient',
      query: { index }
    })
};

</script>

<template>
  <div class="flex-col page">
    <div>
      <TopButton/>
    </div>
    <span class="self-start text">{{ email }}'s refrigerator</span>
    <div class="flex-row self-stretch group">
      <div class="flex-col justify-start items-center text-wrapper"><span class="font text_2">Fridge</span></div>
      <div class="flex-col justify-start text-wrapper_2 ml-11" @click="navigateToRecommendation"><span class="font text_3">Recommendation</span></div>
      <div class="flex-col justify-start text-wrapper_2 ml-11" @click="navigateToCreator"><span class="font text_3">Creator</span></div>
    </div>
    <GridIngredient :items="items" :onDelete="handleDelete" :onEdit="handleEdit" />
    <div class="flex-row justify-between items-center self-center section_2" style="width: 11rem;">
      <div class="flex-col justify-start items-center button" @click="navigateToManualPage"><span class="font_4">Manual</span></div>
      <div class="flex-col justify-end items-center button" @click="navigateToCameraPage">
        <span class="font_4">Camera</span>
        <input type="file" ref="fileInput" style="display: none" @change="handleFileChange">
      </div>
      <!-- <div class="flex-col justify-start items-center text-wrapper_3"><span class="text_4">+</span>
      </div> -->
    </div>
  </div>
</template>

<style scoped lang="css">
.ml-11 {
  margin-left: 0.69rem;
}

.page {
  padding: 4.13rem 1.13rem 5.5rem 1.13rem;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  height: 100%;
}

.text {
  color: rgb(0, 0, 0);
  font-size: 1.31rem;
  font-family: 'Heiti SC';
  font-weight: 700;
  line-height: 1.31rem;
}

.group {
  margin-top: 2.25rem;
}

.text-wrapper {
  padding: 0.44rem 0 0.44rem;
  background-color: rgb(0, 0, 0);
  border-radius: 0.38rem;
  width: 2.81rem;
  height: 1.56rem;
}

.font {
  font-size: 0.69rem;
  font-family: 'Heiti SC';
  line-height: 0.69rem;
  font-weight: 700;
  color: rgb(0, 0, 0);
}

.text_2 {
  color: rgb(255, 255, 255);
}

.text-wrapper_2 {
  padding: 0.44rem 0 0.44rem;
  background-color: rgb(255, 255, 255);
  border-radius: 0.38rem;
  height: 1.56rem;
}

.text_3 {
  margin-left: 0.25rem;
  margin-right: 0.31rem;
}

.grid {
  margin-top: 1.81rem;
  /* height: 31.25rem; */
  display: grid;
  /* grid-template-rows: repeat(auto-fit, minmax(70px, 1fr)); */
  grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  row-gap: 0.69rem;
  column-gap: 1.31rem;
}

.grid-item {
  padding: 0.69rem 0.69rem 0.69rem 0.75rem;
  background-color: rgb(255, 255, 255);
  border-radius: 0.38rem;
  height: 10rem;
}

.section {
  background-color: rgb(216, 216, 216);
  height: 5.94rem;
  border-left: solid 0.063rem rgb(151, 151, 151);
  border-right: solid 0.063rem rgb(151, 151, 151);
  border-top: solid 0.063rem rgb(151, 151, 151);
  border-bottom: solid 0.063rem rgb(151, 151, 151);
}

.font_2 {
  font-size: 0.56rem;
  font-family: 'Heiti SC';
  line-height: 0.56rem;
  font-weight: 700;
  color: rgb(85, 185, 126);
}

.font_3 {
  font-size: 0.69rem;
  font-family: 'Heiti SC';
  line-height: 0.69rem;
  font-weight: 700;
  color: rgb(151, 151, 151);
}

.section_2 {
  margin-top: 1.88rem;
  border-radius: 1.19rem;
}

.text-wrapper_3 {
  overflow: hidden;
  width: 1.44rem;
  height: 2rem;
}

.text_4 {
  color: rgb(255, 255, 255);
  font-size: 2.44rem;
  font-family: 'Heiti SC';
  font-weight: 700;
  line-height: 2.44rem;
}

.image {
  width: 100%;
  height: 100%;
}

.font_4 {
    font-size: 0.88rem;
    font-family: 'Heiti SC';
    line-height: 0.88rem;
    font-weight: 700;
    color: rgb(255, 255, 255);
  }

  .button {
    padding: 0.56rem 0 0.63rem;
    background-color: rgb(0, 0, 0);
    border-radius: 0.56rem;
    width: 4.63rem;
  }

  .overlay {
    position: absolute;
    top: -5px;
    left: -5px;
    width: 15px;
    height: 15px;
    background-color: #D54B45;
    border-radius: 50%;
  }

.overlay::before,
.overlay::after {
  content: '';
  position: absolute;
  width: 1.5px;
  height: 11px;
  background-color: white;
}

.overlay::before {
  transform: rotate(45deg);
}

.overlay::after {
  transform: rotate(-45deg);
}

.overlay::before {
  top: 30%;
  left: 30%;
  transform-origin: center;
}

.overlay::after {
  top: 10%;
  left: 30%;
  transform-origin: center;
}

.overlay::before {
  transform-origin: 5px 7px;
}

.overlay::after {
  transform-origin: 2.5px 3px;
}

</style>